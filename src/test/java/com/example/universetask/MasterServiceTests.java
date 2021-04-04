package com.example.universetask;

import com.example.universetask.dao.MastersMapper;
import com.example.universetask.entity.Master;
import com.example.universetask.serivce.impl.MasterServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class MasterServiceTests {
    private MastersMapper mastersMapper = Mockito.mock(MastersMapper.class);
    private MasterServiceImpl service;
    private Master m1;
    private Master m2;
    @Captor
    private ArgumentCaptor<Master> argumentCaptor;

    @BeforeEach
    void setUp(){

        m1 = new Master();
        m2=new Master();
        m1.setAge(3);
        m1.setName("Andrew");
        m2.setAge(33);
        m2.setName("Anna");
        service= new MasterServiceImpl(mastersMapper);

    }
    @Test
    void shouldFindMasterByName(){
        Mockito.when(mastersMapper.getMasterByName("Andrew")).thenReturn(m1);
        Master actualMaster=service.getMasterByName("Andrew");
        Assertions.assertThat(actualMaster.getName()).isEqualTo("Andrew");
        Assertions.assertThat(actualMaster.getAge()).isEqualTo(3);
    }
    @Test
    void shouldInsertMaster() {
        service.insert(m1);
        Mockito.verify(mastersMapper, Mockito.times(1)).insert(argumentCaptor.capture());
        Assertions.assertThat(argumentCaptor.getValue().getName()).isEqualTo("Andrew");
        Assertions.assertThat(argumentCaptor.getValue().getAge()).isEqualTo(3);
    }



}
