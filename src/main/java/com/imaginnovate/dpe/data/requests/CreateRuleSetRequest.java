package com.imaginnovate.dpe.data.requests;

import io.smallrye.common.constraint.NotNull;
import jakarta.annotation.Nullable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateRuleSetRequest {

    @NotNull
    @NotBlank(message = "Title cannot be null or blank")
    private String name;

    @Nullable
    private String description;

}
