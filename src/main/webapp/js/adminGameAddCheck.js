document.addEventListener('DOMContentLoaded', function () {
    let urlParams = new URLSearchParams(window.location.search);

    document.getElementById('displayDay').textContent = urlParams.get('gameDay') || '';
    document.getElementById('hiddenDay').value = urlParams.get('gameDay') || '';

    document.getElementById('displayTime').textContent = urlParams.get('gameTime') || '';
    document.getElementById('hiddenTime').value = urlParams.get('gameTime') || '';

    document.getElementById('displayHomeTeam').textContent = urlParams.get('homeTeam') || '';
    document.getElementById('hiddenHomeTeam').value = urlParams.get('homeTeam') || '';

    document.getElementById('displayAwayTeam').textContent = urlParams.get('awayTeam') || '';
    document.getElementById('hiddenAwayTeam').value = urlParams.get('awayTeam') || '';

    document.getElementById('displayStadium').textContent = urlParams.get('stadium') || '';
    document.getElementById('hiddenStadium').value = urlParams.get('stadium') || '';

    document.getElementById('displayStatus').textContent = urlParams.get('status') || '';
    document.getElementById('hiddenStatus').value = urlParams.get('status') || '';
});
