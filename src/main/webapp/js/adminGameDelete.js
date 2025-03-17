// ゲーム一覧→ゲーム削除画面遷移時

document.addEventListener('DOMContentLoaded', function () {
    let urlParams = new URLSearchParams(window.location.search);

    document.getElementById('displayId').textContent = urlParams.get('gameId') || '';
    document.getElementById('hiddenId').value = urlParams.get('gameId') || '';

    document.getElementById('displayDate').textContent = urlParams.get('gameDate') || '';

    document.getElementById('displayTime').textContent = urlParams.get('gameTime') || '';

    document.getElementById('displayHomeTeam').textContent = urlParams.get('homeTeam') || '';

    document.getElementById('displayAwayTeam').textContent = urlParams.get('awayTeam') || '';
    
    document.getElementById('displayStadiumName').textContent = urlParams.get('stadiumName') || '';

});
