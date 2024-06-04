package org.rusgidro.Service;

import lombok.RequiredArgsConstructor;
import org.rusgidro.entity.Recommend;
import org.rusgidro.repos.RecommendRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendService {
    private final RecommendRepo recommendRepo;

    public Recommend getRecommendById(long id){
        return recommendRepo.findById(id).get();
    }

}
