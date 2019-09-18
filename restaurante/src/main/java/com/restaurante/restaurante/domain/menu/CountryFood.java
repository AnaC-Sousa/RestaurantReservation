package com.restaurante.restaurante.domain.menu;

public enum CountryFood {
    THAI{
        SpiceLevel spiceLevel = SpiceLevel.MEDIUM;
    },
    FAST_FOOD{
        SpiceLevel spiceLevel = SpiceLevel.LOW;
    },
    ITALIAN{
        SpiceLevel spiceLevel = SpiceLevel.LOW;
    },
    AMERICAN{
        SpiceLevel spiceLevel = SpiceLevel.MEDIUM;
    },
    ARABIAN{
        SpiceLevel spiceLevel = SpiceLevel.MEDIUM;
    },
    INDIAN{
        SpiceLevel spiceLevel = SpiceLevel.MAX;
    },
    CHINESE{
        SpiceLevel spiceLevel = SpiceLevel.MEDIUM;
    },
    JAPANESE{
        SpiceLevel spiceLevel = SpiceLevel.LOW;
    },
    MEDITERRANEAN{
        SpiceLevel spiceLevel = SpiceLevel.LOW;
    },
    VEGAN{
        SpiceLevel spiceLevel = SpiceLevel.LOW;
    },
    BARBECUE_GRILL{
        SpiceLevel spiceLevel = SpiceLevel.MEDIUM;
    },
    MEXICAN{
        SpiceLevel spiceLevel = SpiceLevel.MAX;
    }
}
