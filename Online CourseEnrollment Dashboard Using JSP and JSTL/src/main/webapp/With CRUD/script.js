/**
 * 
 */
function validateFees() {
    const feeInput = document.getElementById('fees_paid');
    const enteredFee = parseFloat(feeInput.value) || 0;
    const errorDiv = document.getElementById('feeError');
    const submitBtn = document.getElementById('submitBtn');

    errorDiv.textContent = '';
    errorDiv.style.display = 'none';

    if (enteredFee < 0) {
        errorDiv.textContent = 'Fees cannot be negative!';
        errorDiv.style.display = 'block';
        submitBtn.disabled = true;
        return false;
    }

    submitBtn.disabled = false;
    return true;
}

function validateForm() {
    return validateFees();
}

window.onload = function() {
    const feeInput = document.getElementById('fees_paid');
    if (feeInput) {
        feeInput.addEventListener('input', validateFees);
        feeInput.addEventListener('blur', validateFees);
    }
};


