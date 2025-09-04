package com.laptrinhjavaweb.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.constant.BuildingTypeConstant;

public class BuildingTypeUtils {
    private static final Map<String, String> BUILDING_TYPE_MAP = new HashMap<>();
    static {
        BUILDING_TYPE_MAP.put(BuildingTypeConstant.TANG_TRET_CODE, BuildingTypeConstant.TANG_TRET_NAME);
        BUILDING_TYPE_MAP.put("tang_tret", BuildingTypeConstant.TANG_TRET_NAME);
        BUILDING_TYPE_MAP.put("tang tret", BuildingTypeConstant.TANG_TRET_NAME);
        BUILDING_TYPE_MAP.put("TANG_TRET", BuildingTypeConstant.TANG_TRET_NAME);

        BUILDING_TYPE_MAP.put(BuildingTypeConstant.NGUYEN_CAN_CODE, BuildingTypeConstant.NGUYEN_CAN_NAME);
        BUILDING_TYPE_MAP.put("nguyen_can", BuildingTypeConstant.NGUYEN_CAN_NAME);
        BUILDING_TYPE_MAP.put("nguyen can", BuildingTypeConstant.NGUYEN_CAN_NAME);
        BUILDING_TYPE_MAP.put("NGUYEN_CAN", BuildingTypeConstant.NGUYEN_CAN_NAME);

        BUILDING_TYPE_MAP.put(BuildingTypeConstant.NOI_THAT_CODE, BuildingTypeConstant.NOI_THAT_NAME);
        BUILDING_TYPE_MAP.put("noi_that", BuildingTypeConstant.NOI_THAT_NAME);
        BUILDING_TYPE_MAP.put("NOI_THAT", BuildingTypeConstant.NOI_THAT_NAME);
    }

    public static String getType(String oldType) {
        if (oldType == null || oldType.trim().isEmpty())
            return "Không xác định";
        List<String> newTypes = new ArrayList<>();
        for (String item : oldType.split(",")) {
            String code = BUILDING_TYPE_MAP.get(item.trim());
            newTypes.add(code != null ? code : "Không xác định");
        }
        return String.join(",", newTypes);
    }
}
