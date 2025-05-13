package com.staticfinal.module.toss;

public class TossPaymentDto {
    private String orderId;
    private String paymentKey;
    private String orderName;
    private String status;
    private int totalAmount;
    private String method;
    private CardInfo card;
    private String urSeq;
    
    
    

    public String getUrSeq() {
		return urSeq;
	}
	public void setUrSeq(String urSeq) {
		this.urSeq = urSeq;
	}
	// === Getter & Setter ===
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentKey() {
        return paymentKey;
    }
    public void setPaymentKey(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getOrderName() {
        return orderName;
    }
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }

    public CardInfo getCard() {
        return card;
    }
    public void setCard(CardInfo card) {
        this.card = card;
    }

    // === 유틸 ===
    public boolean isSuccess() {
        return "DONE".equalsIgnoreCase(this.status);
    }

    // === 내부 클래스 ===
    public static class CardInfo {
        private String company;
        private String number;

        public String getCompany() {
            return company;
        }
        public void setCompany(String company) {
            this.company = company;
        }

        public String getNumber() {
            return number;
        }
        public void setNumber(String number) {
            this.number = number;
        }
    }
}

