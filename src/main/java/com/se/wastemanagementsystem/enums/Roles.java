package com.se.wastemanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Roles {
    WG("Waste Generator"),
    WC("Waste Collector"),
    WF("Waste Facilitator"),
    GO("Govt. Official"),
    ADMIN("Admin");

    private String label;

}
