package nocom.DenCompany.SimpleApplication.controller.mapper;

import nocom.DenCompany.SimpleApplication.controller.dto.LogDto;
import nocom.DenCompany.SimpleApplication.entity.Log;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LogMapper {
    LogMapper INSTANCE = Mappers.getMapper(LogMapper.class);

    @Mappings({
            @Mapping(source = "inputValue", target = "inputValue"),
            @Mapping(source = "result", target = "result")
    })
    LogDto LogToLogDto(Log log);
    List<LogDto> LogListToLogDtoList(List<Log> logs);
    @InheritInverseConfiguration
    Log LogDtoToLog(LogDto primary);
}
