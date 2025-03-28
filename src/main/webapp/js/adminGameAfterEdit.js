//編集画面→編集内容確認画面

document.addEventListener('DOMContentLoaded', function () {
    let urlParams = new URLSearchParams(window.location.search);

    document.getElementById('displayId').textContent = urlParams.get('gameId') || '';
    document.getElementById('gameId').value = urlParams.get('gameId') || '';

    document.getElementById('displayDate').textContent = urlParams.get('gameDay') || '';
    document.getElementById('gameDay').value = urlParams.get('gameDay') || '';
    
    let gameTime = urlParams.get('gameTime') || '';

        // 秒まで表記されたものを分表記に変換
        if (gameTime) {
            const parts = gameTime.split(':');
            if (parts.length === 3) {
                gameTime = `${parts[0]}:${parts[1]}`;
            }
        }
        
        console.log(gameTime);

    document.getElementById('displayTime').textContent = gameTime;
    document.getElementById('gameTime').value = gameTime;

    document.getElementById('displayHomeTeam').textContent = urlParams.get('homeTeam') || '';
//    document.getElementById('homeTeam').value = urlParams.get('homeTeam') || '';

    document.getElementById('displayAwayTeam').textContent = urlParams.get('awayTeam') || '';
    document.getElementById('awayTeam').value = urlParams.get('awayTeam') || '';

    document.getElementById('displayStadium').textContent = urlParams.get('stadium') || '';
    document.getElementById('stadium').value = urlParams.get('stadium') || '';});
