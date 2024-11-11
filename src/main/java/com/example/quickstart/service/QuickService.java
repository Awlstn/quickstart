package com.example.quickstart.service;

import com.example.quickstart.dto.ItemDto;
import com.example.quickstart.entity.ItemEntity;
import com.example.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuickService {

    @Autowired
    private ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto){

        log.info("service ...");

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId()); //
        itemEntity.setName(itemDto.getName());
        itemRepository.save(itemEntity); // 저장

        return true;
    }

    public ItemDto getItemById(String id){

        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();

        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());
        return itemDto;
    }
}
