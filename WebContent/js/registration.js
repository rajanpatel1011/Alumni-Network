document.addEventListener("DOMContentLoaded", () => {
    const signupForm = document.getElementById("signupForm");
    const verificationForm = document.getElementById("verificationForm");
    const statusMessage = document.getElementById("statusMessage");
    const verificationEmail = document.getElementById("verificationEmail");

    signupForm.addEventListener("submit", async (event) => {
        event.preventDefault();
        statusMessage.textContent = "Sending verification code...";

        try {
            const response = await fetch(signupForm.action, {
                method: "POST",
                body: new URLSearchParams(new FormData(signupForm))
            });
            const result = await response.json();
            statusMessage.textContent = result.message;
            if (response.ok) {
                verificationEmail.value = document.getElementById("inputEmail").value;
                signupForm.hidden = true;
                verificationForm.hidden = false;
                document.getElementById("verificationCode").focus();
            }
        } catch (error) {
            statusMessage.textContent = "Registration is temporarily unavailable. Please try again.";
        }
    });

    verificationForm.addEventListener("submit", async (event) => {
        event.preventDefault();
        statusMessage.textContent = "Checking verification code...";

        try {
            const response = await fetch("/EmailVerificationCodeSERVLET", {
                method: "POST",
                body: new URLSearchParams(new FormData(verificationForm))
            });
            const result = await response.json();
            statusMessage.textContent = result.message;
            if (response.ok && result.verified) {
                verificationForm.hidden = true;
            }
        } catch (error) {
            statusMessage.textContent = "Verification is temporarily unavailable. Please try again.";
        }
    });
});
