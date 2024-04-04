package ua.dokat.entity.enums;

public enum SkinRarity {

    CONTRABAND("contraband", 0),
    ANCIENT("ancient", 1),
    ANCIENT_WEAPON("ancient_weapon", 2),
    ANCIENT_CHARACTER("ancient_character", 3),
    LEGENDARY_WEAPON("legendary_weapon", 4),
    LEGENDARY_CHARACTER("legendary_character", 5),
    LEGENDARY("legendary", 6),
    MYTHICAL_WEAPON("mythical_weapon", 7),
    MYTHICAL_CHARACTER("mythical_character", 8),
    MYTHICAL("mythical", 9),
    RARE_WEAPON("rare_weapon", 10),
    RARE_CHARACTER("rare_character", 11),
    RARE("rare", 12),
    UNCOMMON_WEAPON("uncommon_weapon", 13),
    COMMON("common", 14),
    COMMON_WEAPON("common_weapon", 15),
    NON_GRADE("non_grade", 16);

    private final String cmd;
    private final int id;

    SkinRarity(String cmd, int id) {
        this.cmd = cmd;
        this.id = id;
    }

    public String getCmd(){
        return cmd;
    }

    public static SkinRarity getRarityByName(String cmd){
        for (SkinRarity type : SkinRarity.values()){
            if (type.cmd.equals(cmd)){
                return type;
            }
        }

        return NON_GRADE;
    }

    public static SkinRarity getRarityById(int id){
        for (SkinRarity type : SkinRarity.values()){
            if (type.id == id){
                return type;
            }
        }

        return NON_GRADE;
    }
}
