package br.sicredi.devdojosecurity.demo.error;


import lombok.Getter;

@Getter
public class ResourceNotFoundDetails {

    private String title;
    private int status;
    private  String detail;
    private long timeStamp;
    private String developerMessage;

    private ResourceNotFoundDetails() {

    }

    public static final class ResourceNotFoundDetailsBuilder {
        private String title;
        private int status;
        private  String detail;
        private long timeStamp;
        private String developerMessage;

        private ResourceNotFoundDetailsBuilder() {
        }

        public static ResourceNotFoundDetailsBuilder newBuilder() {
            return new ResourceNotFoundDetailsBuilder();
        }

        public ResourceNotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ResourceNotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ResourceNotFoundDetailsBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public ResourceNotFoundDetailsBuilder timeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public ResourceNotFoundDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.title = this.title;
            resourceNotFoundDetails.detail = this.detail;
            resourceNotFoundDetails.timeStamp = this.timeStamp;
            resourceNotFoundDetails.developerMessage = this.developerMessage;
            resourceNotFoundDetails.status = this.status;
            return resourceNotFoundDetails;
        }
    }
}
