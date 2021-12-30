package com.webclient.estudo.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JsonPlaceHolderModel {

    private String id;
    private String title;
    private String body;
    private String userId;


}
