package com.example.myhotel.dtos.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewGuestDetailsResponse {
    private String guestName;
    private String guestEmail;
    private String guestPhone;

}
