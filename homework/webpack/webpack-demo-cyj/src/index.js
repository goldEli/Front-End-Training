import _ from 'lodash';

  function component() {
    const element = document.createElement('div');

    element.innerHTML = "excuse me webpack!";

    return element;
  }

  document.body.appendChild(component());