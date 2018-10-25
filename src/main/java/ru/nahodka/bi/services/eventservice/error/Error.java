package ru.nahodka.bi.services.eventservice.error;


import ru.nahodka.services.common.schemas.exceptions._1_0.ErrorCode;
import ru.nahodka.services.schemas._1_0.BiException;

import static java.text.MessageFormat.format;

public class Error {

    private static BiException generateException(ErrorCode errorCode, String message, String details) {
        ru.nahodka.services.common.schemas.exceptions._1_0.BiException faultInfo =
                new ru.nahodka.services.common.schemas.exceptions._1_0.BiException();
        faultInfo.setDetails(details);
        faultInfo.setErrorCode(errorCode);
        return new BiException(message, faultInfo);
    }

    private static BiException generateException(ErrorCode errorCode, String message) {
        return generateException(errorCode, message, null);
    }

    public static BiException nonUniqueDatasourceCodeException() {

        String message = "Обнаружено неуникальное значение DatasourceCode";
        return generateException(ErrorCode.NON_UNIQUE_DATA_SOURCE_CODE, message);
    }
    public static BiException emptyFactsException() {

        String message = "Отсутствует, либо пуст обязательный элемент Fact";
        return generateException(ErrorCode.EMPTY_FACTS, message);
    }



    public static BiException emptyEgeResultException() {

        String message = "Запрос на результат ЕГЭ пуст";
        return generateException(ErrorCode.EMPTY_EGE_REQUEST, message);
    }

    public static BiException wrongDateApplicationException() {

        String message = "Запрос на результат ЕГЭ пуст";
        return generateException(ErrorCode.WRONG_DATE, message);
    }


    public static BiException emptyDictionaryContentRequest() {

        String message = "Запрос на содержание справочников пуст";
        return generateException(ErrorCode.EMPTY_DICTIONARY_CONTENT_REQUEST, message); //
    }

    public static BiException emptyAppealCancelRequest() {

        String message = "Запрос на отмену апелляции пуст";
        return generateException(ErrorCode.EMPTY_APPEAL_CANCEL_REQUEST_EXCEPTION, message);
    }

    public static BiException notFound() {

        String message = "Результат не найден";
        return generateException(ErrorCode.NOT_FOUND, message);
    }

    public static BiException emptyServiceCodeException() {

        String message = "Отсутствует, либо пуст обязательный элемент ServiceCode";
        return generateException(ErrorCode.EMPTY_SERVICE_CODE_EXCEPTION, message);
    }

    public static BiException emptyServiceNameException() {

        String message = "Отсутствует, либо пуст обязательный элемент ServiceName";
        return generateException(ErrorCode.EMPTY_SERVICE_NAME_EXCEPTION, message);
    }

    public static BiException emptyIdApplicationException() {

        String message = "Отсутствует, либо пуст обязательный элемент IdApplication";
        return generateException(ErrorCode.EMPTY_ID_APPLICATION_EXCEPTION, message);
    }

    public static BiException emptyDateApplicationException() {

        String message = "Отсутствует, либо пуст обязательный элемент DateApplication";
        return generateException(ErrorCode.EMPTY_DATE_APPLICATION_EXCEPTION, message);
    }

    public static BiException emptyAppTypeException() {

        String message = "Отсутствует, либо пуст обязательный элемент AppType";
        return generateException(ErrorCode.EMPTY_APP_TYPE_EXCEPTION, message);
    }

    public static BiException emptySNILSException() {

        String message = "Отсутствует, либо пуст обязательный элемент SNILS";
        return generateException(ErrorCode.EMPTY_SNILS_EXCEPTION, message);
    }

    public static BiException emptyLastNameGrException() {

        String message = "Отсутствует, либо пуст обязательный элемент Last_Name_gr";
        return generateException(ErrorCode.EMPTY_LAST_NAME_EXCEPTION, message);
    }

    public static BiException emptyApplicantSurnameException() {

        String message = "Отсутствует, либо пуст обязательный элемент ApplicantSurname.LastName";
        return generateException(ErrorCode.EMPTY_LAST_NAME_EXCEPTION, message);
    }

    public static BiException emptyFirstNameGrException() {

        String message = "Отсутствует, либо пуст обязательный элемент First_Name_gr";
        return generateException(ErrorCode.EMPTY_FIRST_NAME_EXCEPTION, message);
    }

    public static BiException emptyApplicantNameException() {

        String message = "Отсутствует, либо пуст обязательный элемент ApplicantName.First_name";
        return generateException(ErrorCode.EMPTY_FIRST_NAME_EXCEPTION, message);
    }

    public static BiException emptyPassportSeriesException() {

        String message = "Отсутствует, либо пуст обязательный элемент Pas_ser_gr";
        return generateException(ErrorCode.EMPTY_PASSPORT_SERIES_EXCEPTION, message);
    }

    public static BiException emptyApplicantPassportSeriesException() {

        String message = "Отсутствует, либо пуст обязательный элемент ApplicantPassportSeries.Pas_ser";
        return generateException(ErrorCode.EMPTY_PASSPORT_SERIES_EXCEPTION, message);
    }

    public static BiException emptyPassportNumberException() {

        String message = "Отсутствует, либо пуст обязательный элемент Pas_num_gr";
        return generateException(ErrorCode.EMPTY_PASSPORT_NUMBER_EXCEPTION, message);
    }

    public static BiException emptyApplicantPassportNumberException() {

        String message = "Отсутствует, либо пуст обязательный элемент ApplicantPassportNumber.Pas_num";
        return generateException(ErrorCode.EMPTY_PASSPORT_NUMBER_EXCEPTION, message);
    }

    public static BiException emptyPassportDateException() {

        String message = "Отсутствует, либо пуст обязательный элемент Pas_date_gr";
        return generateException(ErrorCode.EMPTY_PASSPORT_DATE_EXCEPTION, message);
    }

    public static BiException emptyApplicantPassportDateException() {

        String message = "Отсутствует, либо пуст обязательный элемент ApplicantPassportDate.Pas_date";
        return generateException(ErrorCode.EMPTY_PASSPORT_DATE_EXCEPTION, message);
    }

    public static BiException emptyPassportOrgException() {

        String message = "Отсутствует, либо пуст обязательный элемент Pas_org_gr";
        return generateException(ErrorCode.EMPTY_PASSPORT_ORG_EXCEPTION, message);
    }

    public static BiException emptyApplicantPassportOrgException() {

        String message = "Отсутствует, либо пуст обязательный элемент ApplicantPassportOrg.Pas_org";
        return generateException(ErrorCode.EMPTY_PASSPORT_ORG_EXCEPTION, message);
    }

    public static BiException emptyApplicantEqualsExamineeException() {

        String message = "Отсутствует, либо пуст обязательный элемент ApplicantEqualsExaminee";
        return generateException(ErrorCode.EMPTY_APPLICANT_EQUALS_EXAMINEE_EXCEPTION, message);
    }

    public static BiException emptyYearExamException() {

        String message = "Недопустимое значение элемента YearExam";
        return generateException(ErrorCode.EMPTY_YEAR_EXAM_EXCEPTION, message);
    }

    public static BiException emptyCodeSubjectException() {

        String message = "Отсутствует, либо пуст обязательный элемент CodeSubject";
        return generateException(ErrorCode.EMPTY_CODE_SUBJECT_EXCEPTION, message);
    }

    public static BiException wrongRegionCodeException() {

        String message = "Недопустимое значение кода региона";
        return generateException(ErrorCode.WRONG_REGION_EXCEPTION, message);
    }

    public static BiException emptySubjectTextException() {

        String message = "Отсутствует, либо пуст обязательный элемент YearExam";
        return generateException(ErrorCode.EMPTY_SUBJECT_TEXT_EXCEPTION, message);
    }

    public static BiException emptyExamDateException() {

        String message = "Отсутствует, либо пуст обязательный элемент DateExam";
        return generateException(ErrorCode.EMPTY_EXAM_DATE_EXCEPTION, message);
    }

    public static BiException emptyCodeSchoolException() {

        String message = "Отсутствует, либо пуст обязательный элемент CodeSchool";
        return generateException(ErrorCode.EMPTY_CODE_SCHOOL_EXCEPTION, message);
    }

    public static BiException emptySchoolException() {

        String message = "Отсутствует, либо пуст обязательный элемент School";
        return generateException(ErrorCode.EMPTY_SCHOOL_TEXT_EXCEPTION, message);
    }

    public static BiException emptyCodePlaceExamException() {

        String message = "Отсутствует, либо пуст обязательный элемент CodePlaceExam";
        return generateException(ErrorCode.EMPTY_CODE_PLACE_EXAM_EXCEPTION, message);
    }

    public static BiException emptyPlaceExamException() {

        String message = "Отсутствует, либо пуст обязательный элемент PlaceExam";
        return generateException(ErrorCode.EMPTY_PLACE_EXAM_EXCEPTION, message);
    }

    public static BiException emptyPresenceException() {

        String message = "Отсутствует, либо пуст обязательный элемент Presence";
        return generateException(ErrorCode.EMPTY_PRESENCE_EXCEPTION, message);
    }

    public static BiException emptyPresenceTextException() {

        String message = "Отсутствует, либо пуст обязательный элемент PresenceText";
        return generateException(ErrorCode.EMPTY_PRESENCE_EXCEPTION, message);
    }







    public static BiException missingDateException(String elementName) {

        String message = "Отсутствует обязательный элемент";
        String details = format("Element: {0}", elementName);
        return generateException(ErrorCode.MISSING_DATE, message, details);
    }


    public static BiException nonUniqueFactTypeCodeException() {

        String message = "Обнаружено неуникальное значение FactTypeCode";
        return generateException(ErrorCode.NON_UNIQUE_FACT_TYPE_CODE, message);
    }

    public static BiException nonExistingDatasourceCodeException(String datasourceCode) {

        String message = "Указанный DatasourceCode не существует";
        String details = format("DatasourceCode: {0}", datasourceCode);
        return generateException(ErrorCode.NON_EXISTING_DATA_SOURCE_CODE, message, details);
    }

    public static BiException nonExistingFactTypeCodeException(String factTypeCode) {

        String message = "Указанный FactTypeCode не существует";
        String details = format("FactTypeCode: {0}", factTypeCode);
        return generateException(ErrorCode.NON_EXISTING_FACT_TYPE_CODE, message, details);
    }

    public static BiException nonExistingFactValueTypeCodeException(long factValueTypeCode) {

        String message = "Указанный FactValueTypeCode не существует";
        String details = format("FactValueTypeCode: {0}", factValueTypeCode);
        return generateException(ErrorCode.NON_EXISTING_FACT_VALUE_TYPE_CODE, message, details);
    }

    public static BiException emptyDimensionsException() {

        String message = "Отсутствует, либо пуст обязательный элемент Dimensions";
        return generateException(ErrorCode.EMPTY_DIMENSIONS, message);
    }

    public static BiException emptyAppealRequestException() {

        String message = "Отсутствует, либо пуст обязательный элемент AppealRequest";
        return generateException(ErrorCode.EMPTY_APPEAL_REQUEST_EXCEPTION, message);
    }

    public static BiException ambiguousDimensionReferenceException(String dimensionCode, String dimensionAlias) {

        String message =
                "Невозможно определить измерение в таблице фактов, " +
                        "так существуют несколько ссылок на одно измерение внутри таблицы фактов. " +
                        "Проверьте корректность указанного DimensionAlias. ";
        String details = format("DimensionCode: {0}, DimensionAlias: {1}", dimensionCode, dimensionAlias);
        message += details;
        return generateException(ErrorCode.AMBIGIOUS_DIMENSION_REFERENCE, message, details);
    }

    public static BiException missingReferenceLinkInDimensionException(long dimensionCode) {

        String message = "Отсутствует обязательный элемент ReferenceLink";
        String details = format("DimensionCode: {0}", dimensionCode);
        return generateException(ErrorCode.MISSING_REFERENCE_LINK_IN_DIMENSION, message, details);
    }

    public static BiException internalErrorException() {

        String message = "Произошла внутренняя ошибка";
        return generateException(ErrorCode.INTERNAL_ERROR, message);
    }

    public static BiException dictionaryNotExistException() {

        String message = "Справочника с таким именем не существует";
        return generateException(ErrorCode.DICTIONARY_NOT_EXIST, message);
    }

    public static BiException nonExistingEventTypeCodeException(long eventTypeCode) {

        String message = "Указанный EventTypeCode не существует";
        String details = format("EventTypeCode: {0}", eventTypeCode);
        return generateException(ErrorCode.NON_EXISTING_EVENT_TYPE_CODE, message, details);
    }

    public static BiException nonExistingDimensionInFactTableException(String dimensionCode, String dimensionAlias) {

        String message =
                "Указанное измерение не найдено в таблице фактов. " +
                        "Проверьте корректность указанного DimensionAlias.";
        String details = format("DimensionCode: {0}, DimensionAlias: {1}", dimensionCode, dimensionAlias);
        return generateException(ErrorCode.NON_EXISTING_DIMENSION_IN_FACT_TABLE, message, details);
    }

    public static BiException dimensionConflictWithSeparatedTableUsageException(String dimensionCode, String dimensionAlias) {

        String message =
                "Предоставленные данные измерения конфилктуют со свойством наличия у измерения справочника.";
        String details = format("DimensionCode: {0}, DimensionAlias: {1}", dimensionCode, dimensionAlias);
        return generateException(ErrorCode.DIMENSION_CONFLICT_WITH_SEPARATED_TABLE_USAGE, message, details);
    }

    public static BiException missingDimensionValueException(String dimensionCode) {

        String message = "Отсутствует значение справочника указанного измерения без таблицы.";
        String details = format("DimensionCode: {0}", dimensionCode);
        return generateException(ErrorCode.MISSING_DIMENSION_VALUE, message, details);
    }

    public static BiException nonExistingDimensionItemCodeException(String typeCode, long itemCode) {

        String message = "Не существует записи с указанным кодом в справочнике измерений";
        String details = format("TypeCode: {0}, itemCode: {1}", typeCode, itemCode);
        return generateException(ErrorCode.NON_EXISTING_DIMENSION_ITEM_CODE, message, details);
    }

    public static BiException notEnoughDimensionsException() {

        String message = "В факте указаны не все измерения";
        return generateException(ErrorCode.NOT_ENOUGH_DIMENSIONS, message);
    }



}
