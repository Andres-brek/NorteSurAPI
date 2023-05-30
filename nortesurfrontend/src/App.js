import './App.css';
import Result from './Result';
import React, { useState } from 'react';

function App() {
  const [inputValue1, setInputValue1] = useState('');
  const [inputValue2, setInputValue2] = useState('');
  const [dateValue, setDateValue] = useState('');
  const [formData, setFormData] = useState(null);
  const handleSubmit = (data) => {
    const form = {
      inputValue1,
      inputValue2,
      dateValue
    };
    console.log(formData);
    data.preventDefault();
    setFormData(form);
  };
  return (
    <div className="App">
      <h1 id='title'>Where next?</h1>
      <div id='container'>
        <div id='images'>
          <img src='https://creazilla-store.fra1.digitaloceanspaces.com/emojis/56263/airplane-departure-emoji-clipart-md.png' id='Picture'/>
          <img src='https://creazilla-store.fra1.digitaloceanspaces.com/emojis/56571/airplane-arrival-emoji-clipart-sm.png' id='Picture'/>
          <img src='https://th.bing.com/th/id/OIP.QRl08nbftAy2YRwCbFUMOwHaHY?pid=ImgDet&rs=1' id='Picture'/>
        </div>
        <form id="findForm" onSubmit={handleSubmit}>
          <label id='subTitle' htmlFor='departureAirport' >Departure Airport</label>
          <input type="text" id='textInput' name='departureAirport' value={inputValue1} onChange={(e) => setInputValue1(e.target.value)}/>
          <label id='subTitle' htmlFor='arrivalAirport'>Arrival Airport</label>
          <input type="text" id='textInput' name='arrivalAirport' value={inputValue2} onChange={(e) => setInputValue2(e.target.value)}/>
          <label id='subTitle' htmlFor='date'>Pick a date</label>
          <input type="text" id='textInput' name='date' value={dateValue} onChange={(e) => setDateValue(e.target.value)}/>
          <button type="submit" id='submit'>Submit</button>
        </form>
      </div>
      <Result formData={formData}/>
    </div>
  );
}

export default App;
