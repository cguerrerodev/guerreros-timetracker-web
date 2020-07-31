

const getDeviceType = () => {
    const ua = navigator.userAgent;
    if (/(tablet|ipad|playbook|silk)|(android(?!.*mobi))/i.test(ua)) {
      return "tablet";
    }
    if (
      /Mobile|iP(hone|od|ad)|Android|BlackBerry|IEMobile|Kindle|Silk-Accelerated|(hpw|web)OS|Opera M(obi|ini)/.test(
        ua
      )
    ) {
      return "mobile";
    }
    return "desktop";
  };



  const loadApp = () =>{
      if (getDeviceType == 'mobile'){
        window.location.href = ".";
      }else{
        window.open(".", "Guerrero's Time Tracker", "width=350,height=800, location=no, menubar=no, resizable=no, scrollbars=no, status=no, titlebar=no, left=1000, titlebar=no");
      }

  }