import './Result.css'
import Flight from './Flight';

function Result(props) {
    if (!props.formData) {
        return null;
    }
    return (
        <div className="Result">
            <div id='container'>
                <div id='result'>
                    <div id='information'>
                        <h3 id='subTitle'>Departure Airport</h3>
                        <h4 id='subTitle'>{props.formData.inputValue1}</h4>
                    </div>
                    <div id='information'>
                        <h3 id='subTitle'>Arrival Airport</h3>
                        <h4 id='subTitle'>{props.formData.inputValue2}</h4>
                    </div>
                    <div id='information'>
                        <h3 id='subTitle'>Date</h3>
                        <h4 id='subTitle'>{props.formData.dateValue}</h4>
                    </div>
                </div>
                <div id='Flights'>
                    <Flight formData={props.formData}/>
                </div>
            </div>  
        </div>
    );
}

export default Result;