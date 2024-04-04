package ua.dokat.entity.enums;

public enum SkinType {
    KNIFE("csgo_type_knife"),
    PISTOL("csgo_type_pistol"),
    SNIPER_RIFLE("csgo_type_sniperrifle"),
    RIFLE("csgo_type_rifle"),
    CONTAINER("csgo_type_weaponcase"),
    GLOVES("type_hands"),
    SHOTGUN("csgo_type_shotgun"),
    MUSIC_KIT("csgo_type_musickit"),
    STICKER("csgo_tool_sticker"),
    SUBMACHINE_GUN("csgo_type_smg"),
    MACHINE_GUN("csgo_type_machinegun"),
    AGENT("type_customplayer"),
    NON_TYPE("non_type");

    private final String cmd;

    SkinType(String cmd) {
        this.cmd = cmd;
    }

    public String getCmd(){
        return cmd;
    }

    public static SkinType getType(String cmd){
        for (SkinType type : SkinType.values()){
            if (type.cmd.equals(cmd)){
                return type;
            }
        }

        return NON_TYPE;
    }
}
