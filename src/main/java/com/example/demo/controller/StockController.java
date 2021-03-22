package com.example.demo.controller;


import com.example.demo.Repository.StockRepository;
import com.example.demo.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//声明基于reset控制器
@RequestMapping("/stock")//根url配置
@CrossOrigin
public class StockController {

    @Autowired
    private StockRepository stockRepository;

//    @GetMapping("/findAll")//get请求所有数据
//    public List<Stock> findAll(){
//        return stockRepository.findAll();
//    }
    @PutMapping("/update")
    public void update(@RequestBody Stock stock){
        stockRepository.save(stock);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        stockRepository.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Stock findById(@PathVariable("id") Integer id){
        return stockRepository.findById(id).get();
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Stock> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return stockRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public void save(@RequestBody Stock stock){
        stockRepository.save(stock);
    }
//    @GetMapping("/findAll")
//    public Page<Stock> findAll(int page, int size) {
//        PageRequest pageRequest = PageRequest.of(page, size);
//        return stockRepository.findAll(pageRequest);
//    }
}
