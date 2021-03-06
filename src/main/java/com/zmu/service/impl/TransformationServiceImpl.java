package com.zmu.service.impl;

import com.zmu.dto.*;
import com.zmu.model.*;
import com.zmu.service.ProjectService;
import com.zmu.service.TransformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransformationServiceImpl implements TransformationService {

    @Autowired
    private ProjectService projectService;

    @Override
    public Material DtoToEntity(MaterialDto dto) {
        Material material = Material.builder()
                .measurement(dto.getMeasurement())
                .name(dto.getName())
                .numberOfInvoice(Integer.parseInt(dto.getNumberOfInvoice()))
                .price(Double.parseDouble(dto.getPrice()))
                .quantity(Double.parseDouble(dto.getQuantity()))
                .supplier(dto.getSupplier())
                .localDate(dto.getDate())
                .build();
        getPrice(material);
        return material;
    }

    @Override
    public Car DtoToEntity(CarDto dto) {
        Car car = Car.builder()
                .measurement(dto.getMeasurement())
                .name(dto.getName())
                .number(Integer.parseInt(dto.getNumber()))
                .numberOfInvoice(Integer.parseInt(dto.getNumberOfInvoice()))
                .price(Double.parseDouble(dto.getPrice()))
                .quantity(Double.parseDouble(dto.getQuantity()))
                .supplier(dto.getSupplier())
                .localDate(dto.getDate())
                .endDateInspection(dto.getEndDateInspection())
                .endDateInsurance(dto.getEndDateInsurance())
                .inspection(dto.getInspection())
                .insurance(dto.getInsurance())
                .inspectionPrice(Double.parseDouble(dto.getInspectionPrice()))
                .insurancePrice(Double.parseDouble(dto.getInsurancePrice()))
                .razhNorma(Integer.parseInt(dto.getRazhNorma()))
//
                .toll(dto.getToll())
                .tollPrice(Double.parseDouble(dto.getTollPrice()))
                .endDateToll(dto.getEndDateToll())
                .build();
        getPrice(car);
        return car;
    }

    @Override
    public Clothes DtoToEntity(ClothesDto dto) {
        Clothes clothes = Clothes.builder()
                .measurement(dto.getMeasurement())
                .name(dto.getName())
                .numberOfInvoice(Integer.parseInt(dto.getNumberOfInvoice()))
                .price(Double.parseDouble(dto.getPrice()))
                .quantity(Double.parseDouble(dto.getQuantity()))
                .supplier(dto.getSupplier())
                .localDate(dto.getDate())
                .given(dto.getGiven())
                .number(Integer.parseInt(dto.getNumber()))
                .type(Type.valueOf(dto.getType()))
                .build();
        getPrice(clothes);
        return clothes;
    }

    @Override
    public Machine DtoToEntity(MachineDto dto) {
        Machine machine = Machine.builder()
                .measurement(dto.getMeasurement())
                .name(dto.getName())
                .numberOfInvoice(Integer.parseInt(dto.getNumberOfInvoice()))
                .price(Double.parseDouble(dto.getPrice()))
                .quantity(Double.parseDouble(dto.getQuantity()))
                .supplier(dto.getSupplier())
                .localDate(dto.getDate())
                .build();
        getPrice(machine);
        return machine;
    }

    @Override
    public Project DtoToEntity(ProjectDto project) {
        return Project.builder()
                .name(project.getName())
                .city(project.getCity())
                .company(project.getCompany())
                .build();
    }

    private <T extends Good> void getPrice(T good) {
        good.setTotalPrice(good.getPrice() * good.getQuantity());
    }
}
