package ru.geekbrains.mini.market.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.mini.market.entities.Author;

@NoArgsConstructor
@Data
public class AuthorDto {

    @ApiModelProperty(notes = "Unique identifier of the product. No two authors can have the same id.", example = "1", required = true, position = 0)
    private Long id;

    @ApiModelProperty(notes = "Authors name.", example = "Sir Arthur Ignatius Conan Doyle", required = true, position = 1)
    private String name;

    @ApiModelProperty(notes = "Books count.", example = "3", required = true, position = 2)
    private Integer bookCount;

    public AuthorDto(Author a) {
        this.id = a.getId();
        this.name = a.getName();
        this.bookCount = a.getBooks().size();
    }
}
