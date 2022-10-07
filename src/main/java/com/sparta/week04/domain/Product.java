package com.sparta.week04.domain;


import com.sparta.week04.dto.ProductMypriceRequestDto;
import com.sparta.week04.dto.ProductRequestDto;
import com.sparta.week04.entity.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다
@NoArgsConstructor //기본 생성자를 만들어줍니다
@Entity // DB 테이블 역할을 합니다.
public class Product extends Timestamped {

    // ID가 자동으로 생성 및 증가 합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    // 관심 상품 생성 시 이용합니다.
    public Product(ProductRequestDto requesDto) {
        this.title = requesDto.getTitle();
        this.image = requesDto.getImage();
        this.image = requesDto.getLink();
        this.lprice = requesDto.getLprice();
        this.myprice =0;
    }

    public void update(ProductMypriceRequestDto requestDto){
        this.myprice = requestDto.getMyprice();
    }
}
