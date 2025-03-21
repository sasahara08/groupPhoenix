//鐘ケ江
//選手画像の傾け
document.addEventListener('scroll', function () {
  const images = document.querySelectorAll('.left-img, .right-img');
  images.forEach((img) => {
    const rect = img.getBoundingClientRect();
    const windowHeight = window.innerHeight;
    const visibleRatio = Math.min(
      Math.max((windowHeight - rect.top) / windowHeight, 0),
      1
    );

    if (rect.top < windowHeight) {
      // 画像の頭が見えたら開始
      let tiltAmount = Math.min((1 - rect.top / windowHeight) * 30, 30);
      img.style.transform = img.classList.contains('left-img')
        ? `rotate(-${tiltAmount}deg)`
        : `rotate(${tiltAmount}deg)`;
    } else {
      img.style.transform = 'rotate(0deg)';
    }
  });
});
//swiper.js
	const swiper = new Swiper('.sample-slider', {
		loop : true,
		autoplay : {
			// 自動再生させる
			delay : 5000, // 次のスライドに切り替わるまでの時間（ミリ秒）
			disableOnInteraction : false, // ユーザーが操作しても自動再生を止めない
			waitForTransition : false, // アニメーションの間も自動再生を止めない（最初のスライドの表示時間を揃えたいときに）
		},
		effect : 'cards', //追加
		grabCursor : true, //追加
		pagination : {
			el : '.swiper-pagination',
		},
		navigation : {
			nextEl : '.swiper-button-next',
			prevEl : '.swiper-button-prev',
		},
	});
	//JQuery
		let winHeight, winScroll, scrollPos;
		$(window).on('load scroll', function() {
			winScroll = $(window).scrollTop();
			winHeight = $(window).height();
			scrollPos = winHeight * 0.9 + winScroll;
			$('.slidein').each(function() {
				if ($(this).offset().top <= scrollPos) {
					$(this).addClass('show');
				} else {
					$(this).removeClass('show');
				}
			});
		});