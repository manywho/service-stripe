package com.manywho.services.stripe.charge;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;
import com.manywho.sdk.services.types.Type;

@Action.Metadata(name = "Update Charge", summary = "What's happening?", uri = "charge-update")
public class CreateCharge {
    public static class Input {
        @Action.Input(name = "Request Token", contentType = ContentType.String)
        private String requestToken;

        @Type.Property(name = "Amount", contentType = ContentType.Number)
        private Number amount;

        @Type.Property(name = "Currency", contentType = ContentType.String)
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
