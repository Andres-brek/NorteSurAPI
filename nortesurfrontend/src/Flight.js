import './Flight.css'
import axios from 'axios';
import React, { useState } from 'react';

function Flight(props) {
    const [flights,setFlights]=useState([]);
    const Data=() =>{
        axios.get('http://localhost:8080/flights',{params:{departureAirportCode:props.formData.inputValue1,arrivalAirportCode:props.formData.inputValue2,departureDate:props.formData.dateValue}}).then((response)=>{
            console.log(response.data);
            setFlights(response.data);
        })
        .catch((error)=>{
            console.log(error);
        })
    }

    Data();
    return (
        <div>
{flights.map((flight, index) => (
        <div className="Flight" key={index}>
          <div id='Departure'>
            <h3 id='subTitle'>Departure</h3>
            <h4 id='subTitle'>{flight.departureDate}</h4>
            <h4 id='subTitle'>{flight.departureAirportName}</h4>
            <h4 id='subTitle'>{flight.ticketPrice} {flight.ticketCurrency}</h4>
          </div>
          <div id='time'>
            <h3 id='subTitle'>Time</h3>
            <h4 id='subTitle'>{flight.duration}</h4>
          </div>
          <div id='Arrival'>
            <h3 id='subTitle'>Arrival</h3>
            <h4 id='subTitle'>{flight.arrivalDate}</h4>
            <h4 id='subTitle'>{flight.arrivalAirportName}</h4>
            <h4 id='subTitle'>Flight {flight.flightNumber}</h4>
          </div>
        </div>
        ))}
        </div>
    )
}

export default Flight;