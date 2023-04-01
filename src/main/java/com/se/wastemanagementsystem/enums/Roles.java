package com.se.wastemanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Roles {
    WG("Waste Generator"),
    WC("Waste Collector"),
    WF("Waste Facilitator"),
    GO("Govt. Official"),
    ADMIN("Admin");

    private String label;
}
