package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertNotNull;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(StockServiceImplTest.class);
	@Autowired
	StockRepository stockRepository;
	@Autowired
	IStockService stockService;
	@Test
	public void testRetrieveAllStocks(){
		List<Stock> stocks = stockService.retrieveAllStocks();
		assertThat(stocks).size().isGreaterThan(0);
	}
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testAddStock() {
		List<Stock> stocks = stockService.retrieveAllStocks();
		int e=stocks.size();
		Stock s = new Stock("stock test exam",10,100);
		Stock savedStock= stockService.addStock(s);
		
		assertEquals(e + 1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		l.info("Mission added successfuly ");
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testAddStockWithSave() {
		List<Stock> stocks = stockService.retrieveAllStocks();
		int e=stocks.size();
		Stock s = new Stock("stock test exam",10,100);
		Stock savedStock= stockService.addStock(s);
		
		assertEquals(e + 1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		l.info("Mission added and saved successfuly ");
		
	} 
	@Test
	public void testAddStockOptimized() {

		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}
	@Test
	public void testupdateStock(){
		Stock s = new Stock("stock test exam",10,100);
		Assertions.assertNotNull(s);
		stockService.updateStock(s);
		l.info("stock updated successfuly !");
	}

}
