package com.imaginnovate.dpe.data.response;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
public class ZipSearchInfo implements ZipSearch {

	@NotNull(message = "Invalid city name")
	private String city;

	@NotNull(message = "Invalid zip code or state")
	private String stateCode;

	private String countryCode;

	private List<String> zipCode = new ArrayList<>();

}
