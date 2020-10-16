package com.backbase.proto.plaid.model;

import com.backbase.proto.plaid.converter.StringListConverter;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Getter
@Setter
@Entity
@Table(name = "institution")
public class Institution {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "institution_id_generator")
    @GenericGenerator(
        name = "institution_id_generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = @Parameter(name = "sequence_name", value = "institution_seq")
    )
    private Long id;

    @Column(name = "institution_id")
    private String institutionId;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "logo")
    private String logo;

    @Column(name = "primaryColor")
    private String primaryColor;

    @Column(name = "first_created_at")
    private LocalDateTime firstRegisteredAt;

    @Column(name = "first_created_by")
    private String firstCreatedBy;

    @Column(name = "routing_numbers")
    @Lob
    @Convert(converter = StringListConverter.class)
    private List<String> routingNumbers;


}