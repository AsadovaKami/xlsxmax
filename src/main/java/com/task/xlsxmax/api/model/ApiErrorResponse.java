package com.task.xlsxmax.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Схема ответа на ошибки клиента
 */

@Schema(name = "ApiErrorResponse", description = "Схема ответа на ошибки клиента")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-23T16:52:29.646541300+03:00[Europe/Moscow]")
public class ApiErrorResponse {

  @JsonProperty("message")
  private String message;

  public ApiErrorResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Текст ошибки
   * @return message
  */
  @NotNull 
  @Schema(name = "message", example = "Ошибка обработки запроса", description = "Текст ошибки", required = true)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiErrorResponse apiErrorResponse = (ApiErrorResponse) o;
    return Objects.equals(this.message, apiErrorResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiErrorResponse {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

