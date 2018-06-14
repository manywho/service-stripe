package com.manywho.services.stripe.charge;

import com.google.inject.Inject;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;
import com.manywho.services.stripe.ServiceConfiguration;
import com.stripe.Stripe;
import com.stripe.exception.*;

import java.util.HashMap;
import java.util.Map;


public class CreateChargeCommand implements ActionCommand<ServiceConfiguration, CreateCharge, CreateCharge.Input, CreateCharge.Output> {
    private Charge charge;
    private ServiceConfiguration serviceConfiguration;

    @Inject
    public CreateChargeCommand(Charge charge, ServiceConfiguration serviceConfiguration) {
        this.charge = charge;
        this.serviceConfiguration = serviceConfiguration;
    }

    @Override
    public ActionResponse<CreateCharge.Output> execute(ServiceConfiguration serviceConfiguration, ServiceRequest serviceRequest, CreateCharge.Input input) {
        com.stripe.model.Charge stripeCharge;

        try {
            stripeCharge = makeCharge(input.getAmount(), input.getCurrency(), input.getRequestToken());
        } catch (StripeException e) {
            throw new RuntimeException("Error executing charge");
        }
        Charge charge = new Charge(stripeCharge.getId(), stripeCharge.getAmount(), stripeCharge.getCurrency(),
                stripeCharge.getPaid());

        CreateCharge.Output output = new CreateCharge.Output(charge);
        return new ActionResponse<>(output);
    }


    private com.stripe.model.Charge makeCharge(Number amount, String currency, String token) throws StripeException {
        Stripe.apiKey = serviceConfiguration.getSecretKey();

        Map<String, Object> chargeMap = new HashMap<>();
        chargeMap.put("amount", amount);
        chargeMap.put("currency", currency);
        chargeMap.put("source", token); // obtained via Stripe.js
        return com.stripe.model.Charge.create(chargeMap);
    }
}
