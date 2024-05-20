package com.example.demo.metrics.consumer.service;

import com.example.demo.metrics.consumer.dto.UserDto;
import com.example.demo.metrics.consumer.entity.UserEntity;
import com.example.demo.metrics.consumer.mapper.ErrorMapper;
import com.example.demo.metrics.consumer.mapper.UserMapper;
import com.example.demo.metrics.consumer.repository.ErrorRepository;
import com.example.demo.metrics.consumer.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsumerServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private ErrorRepository errorRepository;

    @Mock
    private UserMapper userMapper;
    @Mock
    private ErrorMapper errorMapper;

    @InjectMocks
    private ConsumerService consumerService;

    @BeforeEach
    void init(){
        consumerService=new ConsumerService(userRepository, userMapper, errorMapper, errorRepository, null);
    }

    @Test
    void testListen_WithValidDto() {
        UserDto user = new UserDto();
        user.setFirstName("Иван");

        when(userMapper.dtoToEntity(user)).thenReturn(new UserEntity());

        consumerService.listen(user);

        verify(userRepository).save(any(UserEntity.class));
    }

    @Test
    public void testListen_WithInvalidDto() {
        UserDto user = new UserDto(null, null, "Иванов", 18);

        assertThrows(RuntimeException.class, () -> consumerService.listen(user));
    }

    @Test
    void getUserMetricById() {
        UserEntity userEntity = new UserEntity(1L, "Иван", "Иванов", 18);
        UserDto userDto = new UserDto(1L, "Иван", "Иванов", 18 );

        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        when(userMapper.entityToDto(userEntity)).thenReturn(userDto);

        UserDto result = consumerService.getUserMetricById(1L);

        assertNotNull(result);
        assertEquals(userDto, result);
    }

    @Test
    void getAllMetrics() {
        List<UserEntity> userEntityList = List.of(new UserEntity(1L, "Иван", "Иванов", 18),
                new UserEntity(2L, "Петр", "Петров", 21));
        List<UserDto> userDtoList = List.of(new UserDto(1L, "Иван", "Иванов", 18 ),
                new UserDto(2L, "Петр", "Петров", 21));

        when(userRepository.findAll()).thenReturn(userEntityList);
        when(userMapper.entityToDtoList(userEntityList)).thenReturn(userDtoList);

        List<UserDto> result = consumerService.getAllMetrics();

        assertNotNull(result);
        assertEquals(userDtoList, result);
    }

}