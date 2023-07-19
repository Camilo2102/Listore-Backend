package com.example.listore.models;

import com.example.listore.utils.IdGeneratorUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class GeneralModel {
    @Id
    @Column(length = 36)
    private String id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public GeneralModel() {
        this.id = IdGeneratorUtil.generateUUID();
    }
}
