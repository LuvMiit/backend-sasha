package org.rusgidro.Service;

import lombok.RequiredArgsConstructor;
import org.rusgidro.dto.TypesIndexResponseDTO;
import org.rusgidro.entity.IndexType;
import org.rusgidro.repos.IndexTypeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndexTypeService {
    private final IndexTypeRepo indexTypeRepo;

    public List<TypesIndexResponseDTO> getAllIndexTypes(){
        List<TypesIndexResponseDTO> typesIndexResponseDTOList = new ArrayList<>();
        List<IndexType> indexTypes = indexTypeRepo.findAll();

        for(IndexType type: indexTypes){
            typesIndexResponseDTOList.add(new TypesIndexResponseDTO(type.getIndexName()));

        }
        return typesIndexResponseDTOList;
    }
    public IndexType getTypeByName(String name){
        return indexTypeRepo.findByIndexName(name);
    }
}
