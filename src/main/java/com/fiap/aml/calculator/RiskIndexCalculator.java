package com.fiap.aml.calculator;

import com.fiap.aml.entity.Charge;
import com.fiap.aml.entity.Wanted;

import java.util.HashMap;
import java.util.List;

public class RiskIndexCalculator {

    // 2
    private String[] violentBehavior = {
            // English
            "HOSTAGE", "FIREARM", "AMMUNITION", "KIDNAPPING", "HARASSMENT", "ASSAULT", "WEAPON", "INJURY", "INJURE",
            // Spanish
            "TOMA DE REHENES", "ARMA DE FUEGO", "MUNICIÓN", "SECUESTRO", "ACOSO", "AGRESIÓN", "ARMA", "LESIÓN",
            // French
            "PRISE D'OTAGES", "ARME À FEU", "MUNITIONS", "ENLÈVEMENT", "HARCÈLEMENT", "AGRESSION", "ARME", "BLESSURE"
    };

    // 3
    private String[] identityFalsification = {
            // English
            "IDENTITY THEFT", "FALSE DOCUMENT", "MAIL FRAUD", "WIRE FRAUD", "FRAUD BY WIRE", "AVOID PROSECUTION",
            // Spanish
            "ROBO DE IDENTIDAD", "DOCUMENTO FALSO", "FRAUDE POSTAL", "FRAUDE POR MEDIOS ELECTRÓNICOS", "EVITAR ENJUICIAMIENTO",
            // French
            "VOL D'IDENTITÉ", "FAUX DOCUMENT", "FRAUDE POSTALE", "FRAUDE PAR VOIE ÉLECTRONIQUE", "ÉVITER DES POURSUITES"
    };

    // 4
    private String[] propertyDamageAndTheft = {
            // English
            "RACKETEERING", "DAMAGE TO PROTECTED COMPUTERS", "ROBBERY", "COERCION", "SECURITIES FRAUD",
            // Spanish
            "ASOCIACIÓN DELICTUOSA", "DAÑO A COMPUTADORAS PROTEGIDAS", "ROBO", "COACCIÓN", "FRAUDE DE VALORES",
            // French
            "ASSOCIATION DE MALFAITEURS", "DOMMAGES AUX ORDINATEURS PROTÉGÉS", "VOL À MAIN ARMÉE", "CONTRAINTE", "FRAUDE SUR LES TITRES"
    };

    // 4
    private String[] heinousViolenceAndDrugDealing = {
            // English
            "METHAMPHETAMINE", "HEROIN", "COCAINE", "MARIJUANA", "NARCOTICS", "CONTROLLED SUBSTANCE",
            "RAPE", "MURDER", "HOMICIDE", "TERRORIST", "TERRORISM", "MASS SHOOTING", "SEX TRAFFICKING",
            // Spanish
            "METANFETAMINA", "HEROÍNA", "COCAÍNA", "MARIHUANA", "NARCÓTICOS", "SUSTANCIA CONTROLADA",
            "VIOLACIÓN", "ASESINATO", "HOMICIDIO", "TERRORISTA", "TERRORISMO", "TIROTEO", "TRÁFICO SEXUAL",
            // French
            "MÉTHAMPHÉTAMINE", "HÉROÏNE", "COCAÏNE", "MARIJUANA", "NARCOTIQUES", "SUBSTANCE CONTRÔLÉE",
            "VIOL", "MEURTRE", "HOMICIDE", "TERRORISTE", "TERRORISME", "FUSILLADE DE MASSE", "TRAITE DES ÊTRES HUMAINS"
    };

    // 5
    private String[] moneyLaunderingAndFinancialFraud = {
            // English
            "BANK FRAUD", "MONEY LAUNDERING", "DEFRAUD", "FINANCIAL FRAUD", "INTERNATIONAL EMERGENCY ECONOMIC POWERS ACT",
            // Spanish
            "FRAUDE BANCARIO", "LAVADO DE DINERO", "DEFRAUDAR", "FRAUDE FINANCIERO", "LEY DE PODERES ECONÓMICOS DE EMERGENCIA INTERNACIONAL",
            // French
            "FRAUDE BANCAIRE", "BLANCHIMENT D'ARGENT", "FRAUDER", "FRAUDE FINANCIÈRE", "LOI SUR LES POUVOIRS ÉCONOMIQUES D'URGENCE INTERNATIONALE"
    };

    public HashMap<Integer, String> calculateAmlRisk(Wanted wanted) {
        HashMap<Integer, String> index = new HashMap<>();
        int level = 1;
        String description = "low risk";

        for (Charge charge : wanted.getCharges()) {
            for (String subject : this.violentBehavior) {
                if (charge.getChargeDescription().toUpperCase().contains(subject)) {
                    level = 2;
                    description = "slight risk";
                }
            }
        }

        for (Charge charge : wanted.getCharges()) {
            for (String subject : this.identityFalsification) {
                if (charge.getChargeDescription().toUpperCase().contains(subject)) {
                    level = 3;
                    description = "moderate risk";
                }
            }
        }

        for (Charge charge : wanted.getCharges()) {
            for (String subject : this.propertyDamageAndTheft) {
                if (charge.getChargeDescription().toUpperCase().contains(subject)) {
                    level = 3;
                    description = "high risk";
                }
            }
        }

        for (Charge charge : wanted.getCharges()) {
            for (String subject : this.heinousViolenceAndDrugDealing) {
                if (charge.getChargeDescription().toUpperCase().contains(subject)) {
                    level = 4;
                    description = "high risk";
                }
            }
        }

        for (Charge charge : wanted.getCharges()) {
            for (String subject : this.heinousViolenceAndDrugDealing) {
                if (charge.getChargeDescription().toUpperCase().contains(subject)) {
                    level = 5;
                    description = "very high risk";
                }
            }
        }

        // Debugging statements
        System.out.println("Level: " + level);
        System.out.println("Description: " + description);

        index.put(level, description);
        return index;
    }
}