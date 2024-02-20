package Java_backend.springstore.service;

import Java_backend.springstore.entity.*;
import Java_backend.springstore.postman.DevicePostman;
import Java_backend.springstore.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class EntityService {

    private final HooverRepository hooverRepository;
    private final PcRepository pcRepository;
    private final TvRepository tvRepository;
    private final SmartphoneRepository smartphoneRepository;
    private final RefrigeratorRepository refrigeratorRepository;
    private final ProductService productService;

    public Pc createPc(DevicePostman deviceDto){
        return  pcRepository.save(Pc.builder()
                .category(deviceDto.getCategory())
                .processor_type(deviceDto.getProcessor_type())
                .product(productService.create(deviceDto))
                .build());
    }
    public Tv createTv(DevicePostman deviceDto){
        return  tvRepository.save(Tv.builder()
                .category(deviceDto.getCategory())
                .technology(deviceDto.getTechnology())
                .product(productService.create(deviceDto))
                .build());
    }
    public Hoover createHoover(DevicePostman deviceDto){
        return  hooverRepository.save(Hoover.builder()
                .dust_container(deviceDto.getDust_container())
                .operating_mode(deviceDto.getOperating_mode())
                .product(productService.create(deviceDto))
                .build());
    }
    public Smartphone createSmartphone(DevicePostman deviceDto) {
        return smartphoneRepository.save(Smartphone.builder()
                .memory(deviceDto.getMemory())
                .cameras(deviceDto.getCameras())
                .product(productService.create(deviceDto))
                .build());
    }
    public Refrigerator createRefrigerator(DevicePostman deviceDto){
        return  refrigeratorRepository.save(Refrigerator.builder()
                .door(deviceDto.getDoor())
                .compressor(deviceDto.getCompressor())
                .product(productService.create(deviceDto))
                .build());
    }
    public Pc updatePc(Pc pc){
        return pcRepository.save(pc);
    }
    public Tv updateTv(Tv tv){
        return tvRepository.save(tv);
    }
    public Hoover updateHoover(Hoover hoover){
        return hooverRepository.save(hoover);
    }
    public Refrigerator updateRefrigerator(Refrigerator refrigerator){
        return refrigeratorRepository.save(refrigerator);
    }
    public Smartphone updateSmartphone(Smartphone smartphone){
        return smartphoneRepository.save(smartphone);
    }

    public List<ArrayList> entity(){
        List<ArrayList> list =new ArrayList<>();
        list.add((ArrayList) pcRepository.findAll());
        list.add((ArrayList) tvRepository.findAll());
        list.add((ArrayList) hooverRepository.findAll());
        list.add((ArrayList) refrigeratorRepository.findAll());
        list.add((ArrayList) smartphoneRepository.findAll());
        return list;
    }

    public List<Object> listEntity (int id){

        switch (id) {

            case 1:
                return Collections.singletonList(pcRepository.findAll());

            case 2:
                return Collections.singletonList(tvRepository.findAll());

            case 3:
                return Collections.singletonList(hooverRepository.findAll());

            case 4:
                return Collections.singletonList(refrigeratorRepository.findAll());

            case 5:
                return Collections.singletonList(smartphoneRepository.findAll());

            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
    }

    public List<Object> createEntity(int id,DevicePostman device){

        switch (id) {

            case 1:
                return Collections.singletonList(createPc(device));

            case 2:
                return Collections.singletonList(createTv(device));

            case 3:
                return Collections.singletonList(createHoover(device));

            case 4:
                return Collections.singletonList(createRefrigerator(device));

            case 5:
                return Collections.singletonList(createSmartphone(device));

            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
    }

    public void deleteEntity(int number,long id){

    switch (number) {

        case 1:
            pcRepository.deleteById(id);
            break;

        case 2:
            tvRepository.deleteById(id);
            break;

        case 3:
            hooverRepository.deleteById(id);
            break;

        case 4:
            refrigeratorRepository.deleteById(id);
            break;

        case 5:
            smartphoneRepository.deleteById(id);
            break;

        default:
            throw new IllegalStateException("Unexpected value: " + id);
    }
    }
}