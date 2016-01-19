package org.keycloak.models;

import java.util.Comparator;
import java.io.Serializable;

/**
* @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
* @version $Revision: 1 $
*/
public class AuthenticationExecutionModel implements Serializable {

    public static class ExecutionComparator implements Comparator<AuthenticationExecutionModel> {
        public static final ExecutionComparator SINGLETON = new ExecutionComparator();

        @Override
        public int compare(AuthenticationExecutionModel o1, AuthenticationExecutionModel o2) {
            return o1.priority - o2.priority;
        }
    }

    private String id;
    private String authenticatorConfig;
    private String authenticator;
    private String flowId;
    private boolean authenticatorFlow;
    private Requirement requirement;
    private int priority;
    private String parentFlow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthenticatorConfig() {
        return authenticatorConfig;
    }

    public void setAuthenticatorConfig(String authenticatorConfig) {
        this.authenticatorConfig = authenticatorConfig;
    }

    public String getAuthenticator() {
        return authenticator;
    }

    public void setAuthenticator(String authenticator) {
        this.authenticator = authenticator;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getParentFlow() {
        return parentFlow;
    }

    public void setParentFlow(String parentFlow) {
        this.parentFlow = parentFlow;
    }

    /**
     * If this execution is a flow, this is the flowId pointing to an AuthenticationFlowModel
     *
     * @return
     */
    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    /**
     * Is the referenced authenticator a flow?
     *
     * @return
     */
    public boolean isAuthenticatorFlow() {
        return authenticatorFlow;
    }

    public void setAuthenticatorFlow(boolean authenticatorFlow) {
        this.authenticatorFlow = authenticatorFlow;
    }

    public enum Requirement {
        REQUIRED,
        OPTIONAL,
        ALTERNATIVE,
        DISABLED
    }

    public boolean isRequired() {
        return requirement == Requirement.REQUIRED;
    }
    public boolean isOptional() {
        return requirement == Requirement.OPTIONAL;
    }
    public boolean isAlternative() {
        return requirement == Requirement.ALTERNATIVE;
    }
    public boolean isDisabled() {
        return requirement == Requirement.DISABLED;
    }
    public boolean isEnabled() {
        return requirement != Requirement.DISABLED;
    }
}