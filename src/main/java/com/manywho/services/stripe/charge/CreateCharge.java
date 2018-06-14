package com.manywho.services.stripe.charge;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;
import com.manywho.sdk.services.types.Type;

@Action.Metadata(name = "Create Charge", summary = "Execute Charge", uri = "charge-create")
public class CreateCharge {
    public static class Input {
        @Action.Input(name = "Request Token", contentType = ContentType.String)
        private String requestToken;

        @Action.Input(name = "Amount", contentType = ContentType.Number)
        private Double amount;

        @Action.Input(name = "Currency", contentType = ContentType.String)
        private String currency;

        public String getRequestToken() {
            return requestToken;
        }

        public Number getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }
    }

    public static class Output {
        @Action.Output(name = "Charge", contentType = ContentType.Object)
        private Charge charge;

        public Output(Charge charge) {
            this.charge = charge;
        }
    }
}
