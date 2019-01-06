package com.zmu.service.impl;

import com.zmu.dto.GoodDto;
import com.zmu.dto.NewMaterialDto;
import com.zmu.model.Good;
import com.zmu.model.NewMaterial;
import com.zmu.service.TransformationService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TransformationServiceImpl<T extends Good, TDto extends GoodDto> implements TransformationService {

    @Override
    public NewMaterial DtoToEntity(NewMaterialDto dto) {
        return NewMaterial.builder()
                .measurement(dto.getMeasurement())
                .name(dto.getName())
                .numberOfInvoice(Integer.parseInt( dto.getNumberOfInvoice()))
                .price(Double.parseDouble(dto.getPrice()))
                .totalPrice(Double.parseDouble(dto.getTotalPrice()))
                .quantity(Double.parseDouble(dto.getQuantity()))
                .build();
    }
}
