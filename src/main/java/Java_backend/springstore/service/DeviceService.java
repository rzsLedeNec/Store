package Java_backend.springstore.service;

import Java_backend.springstore.model.Device;
import Java_backend.springstore.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public List<Device> reedAll(){
        return deviceRepository.findAll();
    }
    public Device build(String categories){
       return deviceRepository.save(Device.builder().
                categories(categories).build());
    }
    public Device findById(int id){
        return deviceRepository.findById(id).orElseThrow(()->
                new RuntimeException("Not Found "+id));
    }
}
