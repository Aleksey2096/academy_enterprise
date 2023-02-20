package by.academy.task07webAnimal.servlet.extractor.impl;

import by.academy.task07webAnimal.entity.AnimalDTO;
import by.academy.task07webAnimal.servlet.extractor.DtoExtractor;

import javax.servlet.http.HttpServletRequest;

import static by.academy.task07webAnimal.entity.Constant.ID;
import static by.academy.task07webAnimal.entity.Constant.NAME;
import static by.academy.task07webAnimal.entity.Constant.WEIGHT;

/**
 * extracts AnimalDTO objects from request.
 */
public final class AnimalDtoExtractor implements DtoExtractor<AnimalDTO> {
    @Override
    public AnimalDTO extract(final HttpServletRequest request) {
        String idString = request.getParameter(ID);
        Integer id = idString == null ? null : Integer.valueOf(idString);
        String weightString = request.getParameter(WEIGHT);
        Double weight = weightString == null ? null
                : Double.valueOf(weightString);
        return AnimalDTO.builder().id(id).name(request.getParameter(NAME))
                .weight(weight).build();
    }
}
