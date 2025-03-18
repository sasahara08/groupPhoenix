//編集画面→編集内容確認画面

document.addEventListener('DOMContentLoaded', function () {
    let urlParams = new URLSearchParams(window.location.search);

    document.getElementById('displayId').textContent = urlParams.get('gameId') || '';
    document.getElementById('gameId').value = urlParams.get('gameId') || '';

    document.getElementById('displayDate').textContent = urlParams.get('gameDay') || '';
    document.getElementById('gameDay').value = urlParams.get('gameDay') || '';

    document.getElementById('displayTime').textContent = urlParams.get('gameTime') || '';
    document.getElementById('gameTime').value = urlParams.get('gameTime') || '';

    document.getElementById('displayHomeTeam').textContent = urlParams.get('homeTeam') || '';
//    document.getElementById('homeTeam').value = urlParams.get('homeTeam') || '';

    document.getElementById('displayAwayTeam').textContent = urlParams.get('awayTeam') || '';
    document.getElementById('awayTeam').value = urlParams.get('awayTeam') || '';

    document.getElementById('displayStadium').textContent = urlParams.get('stadium') || '';
    document.getElementById('stadium').value = urlParams.get('stadium') || '';});
