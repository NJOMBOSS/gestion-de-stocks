package com.approvisionement.approvisionnement.dto;

import com.approvisionement.approvisionnement.entity.MvStk;
import com.approvisionement.approvisionnement.entity.TypeMvtStk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;


@Data
@Builder
public class MvStkDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    @JsonIgnore
    private ArticleDto articleDto;

    @JsonIgnore
    private TypeMvtStk typeMvtStk;

    public MvStkDto fromEntity(MvStk mvStk){
        if(mvStk == null){
            return null;
        }
        return MvStkDto.builder()
                .id(mvStk.getId())
                .dateMvt(getDateMvt())
                .quantite(getQuantite())
                .build();
    }

    public MvStk toEntity(MvStkDto mvStkDto){
        if(mvStkDto == null){
            return null;
        }

        MvStk m = new MvStk();
        m.setId(mvStkDto.getId());
        m.setDateMvt(mvStkDto.getDateMvt());
        m.setQuantite(mvStkDto.getQuantite());
        return m;

    }
}
