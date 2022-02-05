package ua.goit.notesStorage.enums;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NotNull
public enum AccessTypes {

    PRIVATE,//("PRIVATE")
    PUBLIC

}
//    @NotNull
//    private final String accessType;

//    public String getAccessType() {
//        return accessType;
//    }

//    public Optional<AccessTypes> getAccessType(String accessType) {
//        return Arrays.stream(AccessTypes.values())
//                .filter(enumValue -> enumValue.getAccessType().equals(accessType))
//                .findAny();
//    }