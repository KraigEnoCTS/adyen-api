package com.github.woki.payments.adyen.action;

import com.github.woki.payments.adyen.APService;
import com.github.woki.payments.adyen.ClientConfig;
import com.github.woki.payments.adyen.error.APSAccessException;
import com.github.woki.payments.adyen.model.RecurringListDetailsRequest;
import com.github.woki.payments.adyen.model.RecurringListDetailsResponse;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;

/**
 * @author Willian Oki, &ltwillian.oki@gmail.com&gt
 */
public final class RecurringListDetails {
    private RecurringListDetails() {
        // utility
    }

    private static final Logger LOG = LoggerFactory.getLogger(RecurringListDetails.class);

    private static Request createRequest(ClientConfig config, RecurringListDetailsRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("config: {}, request: {}", config, request);
        }
        Request retval = ActionUtil.createPost(APService.RECURRING_LIST_DETAILS, config, request);
        if (LOG.isDebugEnabled()) {
            LOG.debug("retval: {}", retval);
        }
        return retval;
    }

    public static RecurringListDetailsResponse execute(@NotNull ClientConfig config, @NotNull RecurringListDetailsRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("config: {}, request: {}", config, request);
        }
        RecurringListDetailsResponse retval;
        try {
            retval = ActionUtil.executeRecurringListDetails(createRequest(config, request), config);
        } catch (Exception e) {
            LOG.error("recurring list details", e);
            throw new APSAccessException("recurring list details", e);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("retval: {}", retval);
        }
        return retval;
    }
}
