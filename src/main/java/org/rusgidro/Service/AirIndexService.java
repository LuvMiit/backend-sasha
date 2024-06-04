package org.rusgidro.Service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.rusgidro.dto.AirIndexResponseValueDTO;
import org.rusgidro.dto.AllAttributesIndexDTO;
import org.rusgidro.dto.RequestIndexValueDTO;
import org.rusgidro.dto.UpdateValueDTO;
import org.rusgidro.entity.*;
import org.rusgidro.repos.AirIndexRepo;
import org.rusgidro.utils.HibernateUtil;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.rusgidro.utils.IndicatorsCalculate.computeISA;
import static org.rusgidro.utils.IndicatorsCalculate.computePI;

@Service
@RequiredArgsConstructor
public class AirIndexService {
    private final AirIndexRepo airIndexRepo;
    private final IndexTypeService indexTypeService;
    private final SensorTypeService sensorTypeService;
    private final SensorService sensorService;
    private final CityService cityService;
    private final RecommendService recommendService;

    public AirIndexResponseValueDTO getIndexValueAndDescription(RequestIndexValueDTO requestIndex) throws ParseException {
        IndexType index = indexTypeService.getTypeByName(requestIndex.getIndexType());
        SensorType sensorType = sensorTypeService.getSensorTypeByName(requestIndex.getIndexType());
        City city = cityService.getCityByName(requestIndex.getCity());
        Sensor sensor = sensorService.getSensorByTypeAndCity(city, sensorType);

        IndexType indexType = indexTypeService.getTypeByName(requestIndex.getIndexType());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(requestIndex.getDate());
        Double value = airIndexRepo.findByTypeIndexAndSensorAndReadDate(indexType, sensor, date).getIndexValue();
        AirIndexResponseValueDTO airIndexResponseValueDTO = new AirIndexResponseValueDTO();
        airIndexResponseValueDTO.setDescription(indexType.getDescription());
        airIndexResponseValueDTO.setIndexValue(String.valueOf(value));
        if(value>index.getStandart().getStandartValueDAY()){
            airIndexResponseValueDTO.setRecommend(recommendService.getRecommendById(2).getRecommends());
        }else{
            airIndexResponseValueDTO.setRecommend(recommendService.getRecommendById(4).getRecommends());
        }

        return airIndexResponseValueDTO;
    }
    public List<AllAttributesIndexDTO> getAllIndexes() throws ParseException {
        List<AirIndex> airIndexList = airIndexRepo.findAll();
        List<AllAttributesIndexDTO> allAttributesIndexDTOList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(AirIndex index: airIndexList){
            AllAttributesIndexDTO allAttributesIndexDTO = new AllAttributesIndexDTO();
            allAttributesIndexDTO.setIndexName(index.getTypeIndex().getIndexName());
            allAttributesIndexDTO.setValue(index.getIndexValue());
            allAttributesIndexDTO.setDate(sdf.format(index.getReadDate()));
            allAttributesIndexDTO.setCity(index.getSensor().getCity().getCityName());
            allAttributesIndexDTO.setStandart(index.getTypeIndex().getStandart().getStandartValueDAY());
            allAttributesIndexDTO.setDangerClass(index.getDangerClass());
            allAttributesIndexDTO.setIsa(Math.round(computeISA(index.getIndexValue(), index.getDangerClass(),index.getTypeIndex().getStandart().getStandartValueDAY())*1000.0)/1000.0);
            allAttributesIndexDTO.setPi(Math.round(computePI(index.getIndexValue(),index.getTypeIndex().getStandart().getStandartValueDAY())*1000.0)/1000.0);
            allAttributesIndexDTOList.add(allAttributesIndexDTO);
        }

        return allAttributesIndexDTOList;
    }

    public boolean updateValueByDateTypeCity(UpdateValueDTO updatedValue) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SensorType sensorType = sensorTypeService.getSensorTypeByName(updatedValue.getTypeIndex());
        City city = cityService.getCityByName(updatedValue.getCity());
        Sensor sensor = sensorService.getSensorByTypeAndCity(city, sensorType);
        IndexType indexType = indexTypeService.getTypeByName(updatedValue.getTypeIndex());
        AirIndex airIndex = airIndexRepo.findByTypeIndexAndSensorAndReadDate(indexType, sensor, sdf.parse(updatedValue.getDate()));

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.evict(airIndex);
            airIndex.setIndexValue(updatedValue.getNewValue());
            session.merge(airIndex);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
