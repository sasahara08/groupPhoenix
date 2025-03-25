document.addEventListener('DOMContentLoaded', function () {
    let urlParams = new URLSearchParams(window.location.search);

    document.getElementById('displayId').textContent = urlParams.get('editGameId') || '';
    document.getElementById('hiddenId').value = urlParams.get('editGameId') || '';

    document.getElementById('gameDay').value = urlParams.get('editGameDate') || '';

    let gameTime = urlParams.get('editGameTime') || '';

    // 秒まで表記されたものを分表記に変換
    if (gameTime) {
        const parts = gameTime.split(':');
        if (parts.length === 3) {
            gameTime = `${parts[0]}:${parts[1]}`;
        }
    }

    document.getElementById('gameTime').value = gameTime;
});